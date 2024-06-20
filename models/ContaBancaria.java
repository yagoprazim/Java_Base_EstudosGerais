package models;

import exceptions.CustomErrorException;

public class ContaBancaria {
    Long id;
    String name;
    String cpf;
    Integer tipoConta;
    double saldo;

    public ContaBancaria(Long id, String name, String cpf, Integer tipoConta, double saldo) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", tipoConta=" + tipoConta +
                ", saldo=" + saldo +
                '}';
    }

    //Funcoes Extras:
    public void sacar(double valor) throws CustomErrorException {
        if(this.saldo < valor || valor <= 0) {
            throw new CustomErrorException("Valor de saque inválido.");
        }
        else {
            this.saldo -= valor;
        }
    }

    public void depositar(double valor) throws CustomErrorException {
        if(valor > 0) {
            this.saldo += valor;
        }
        else {
            throw new CustomErrorException("Valor de depósito inválido.");
        }

    }

}
