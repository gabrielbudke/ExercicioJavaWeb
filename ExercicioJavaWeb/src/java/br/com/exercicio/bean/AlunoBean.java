package br.com.exercicio.bean;

/**
 * @author Gabriel Budke
 */
public class AlunoBean {

    private int id;
    private String nome, codigo_matricula, situacao;
    private float nota1, nota2, nota3, nota4, media;
    private byte frequencia;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(String codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota_2() {
        return nota2;
    }

    public void setNota_2(float nota_2) {
        this.nota2 = nota_2;
    }

    public float getNota_3() {
        return nota3;
    }

    public void setNota_3(float nota_3) {
        this.nota3 = nota_3;
    }

    public float getNota_4() {
        return nota4;
    }

    public void setNota_4(float nota_4) {
        this.nota4 = nota_4;
    }

    public byte getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(byte frequencia) {
        this.frequencia = frequencia;
    }
    
    public double calcularMedia(){
        return nota1 + nota2 + nota3 + nota4 / 4;

}
