package br.com.kr.vendas.beans;

import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.exceptions.ValidarEnderecoException;
import br.com.kr.vendas.model.Cliente;
import br.com.kr.vendas.model.Endereco;
import br.com.kr.vendas.services.ClienteService;
import br.com.kr.vendas.services.EnderecoService;
import br.com.kr.vendas.utils.FacesUtils;
import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

    @Inject
    private ClienteService clienteService;

    @Inject
    private EnderecoService enderecoService;

    private Cliente cliente =  new Cliente();

    private Endereco endereco = new Endereco();

    private String cep;

    private boolean disableCep;

    private boolean disableConfirmar = true;

    private boolean confirmouEndereco;

    private ViaCEPClient viaCEPClient = new ViaCEPClient();

    public void limparCache(){
        endereco = new Endereco();
        cliente = new Cliente();
        cep = null;
        disableCep = false;
        disableConfirmar = true;

    }

    public void buscaCep(){
        try {
            endereco = new Endereco();
            endereco.setUF(viaCEPClient.getEndereco(cep).getUf());
            endereco.setCep(viaCEPClient.getEndereco(cep).getCep().replace("-",""));
            endereco.setCidade(viaCEPClient.getEndereco(cep).getLocalidade());
            disableConfirmar = false;
        } catch (Exception e) {
            e.printStackTrace();
            disableConfirmar = true;
            FacesUtils.addWarningMessage("cepInformadoInvalido");
        }

    }

    public void removerEndereco(){
        endereco = new Endereco();
        disableConfirmar = true;
        disableCep = false;

    }

    public void confirmarCEP(){
        try {
            if (endereco.getCep() != null) {
                disableCep = true;
                confirmouEndereco = true;
                FacesUtils.addSuccessMessage("confirmadoSucesso");
            } else {
                throw new ValidarEnderecoException("enderecoConfirmaNulo");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Transactional
    public void confirmarCadastroCliente() throws Exception{
        try {
            if(endereco.getCep() != null && confirmouEndereco) {
                cliente.setEndereco(endereco);
                enderecoService.save(endereco);
                clienteService.save(cliente);
                limparCache();
                FacesUtils.addSuccessMessage("SalvoSucesso");
            }else{
                throw new ValidarEnderecoException("enderecoNulo");
            }
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erroAoCadastrarCliente");
            resestaEntidade();
            throw e;
        }

    }

    public void resestaEntidade(){
        endereco.setId(null);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ViaCEPClient getViaCEPClient() {
        return viaCEPClient;
    }

    public void setViaCEPClient(ViaCEPClient viaCEPClient) {
        this.viaCEPClient = viaCEPClient;
    }

    public boolean isDisableCep() {
        return disableCep;
    }

    public void setDisableCep(boolean disableCepl) {
        this.disableCep = disableCepl;
    }

    public boolean isDisableConfirmar() {
        return disableConfirmar;
    }

    public void setDisableConfirmar(boolean disableConfirmar) {
        this.disableConfirmar = disableConfirmar;
    }

}
