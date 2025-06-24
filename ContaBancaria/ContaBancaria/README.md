# 🏦 Sistema Bancário Simples em Java

Um projeto de terminal feito em Java que simula um sistema bancário com funcionalidades como criação de conta, depósitos, saques, transferências e listagem de contas. O número da conta é gerado automaticamente e é único.

---

## 🧠 Funcionalidades

- Criar conta com número aleatório e único
- Depositar valores
- Sacar valores com verificação de saldo
- Transferir entre contas
- Listar todas as contas existentes
- (Modularizado em classes separadas)

---

## 📁 Estrutura do Projeto

SistemaBancarioSimples/
├── src/
│ ├── model/
│ │ ├── Conta.java # Classe de modelo da conta
│ │ └── Banco.java # Gerencia todas as contas
│ └── app/
│ └── Main.java # Interface de terminal
├── data/
│ └── contas.txt # (Opcional) para persistência futura
└── README.md

yaml
Copiar
Editar

---

## ▶️ Como executar

1. Clone ou baixe este projeto.

2. Compile os arquivos:
```bash
javac src/model/Conta.java src/model/Banco.java src/app/Main.java
Execute o programa:

bash
Copiar
Editar
java -cp src app.Main
🛠️ Tecnologias usadas
Java SE (sem bibliotecas externas)

Estrutura orientada a objetos (POO)

Entrada de dados via Scanner

Lógica de negócios e controle de fluxo

🚀 Possíveis Melhorias Futuras
Adicionar senha por conta

Histórico de transações (extrato)

Interface gráfica com Swing

Salvamento e carregamento automático (persistência com arquivos)

Tipos de conta (Corrente, Poupança)

📄 Licença
Projeto livre para fins educacionais e pessoais.

perl
Copiar
Editar
