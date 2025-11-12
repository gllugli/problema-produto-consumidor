# Projeto: Produtor–Consumidor com Semáforos

## Descrição

Este projeto implementa o problema clássico de **Produtor–Consumidor**, também conhecido como **Oferta e Procura**, utilizando a linguagem **Java**. O objetivo é demonstrar, de forma prática, conceitos de **concorrência, sincronização de processos e gerenciamento de recursos** estudados na disciplina de **Sistemas Operacionais**.

O sistema simula um ambiente em que múltiplas threads produtoras e consumidoras compartilham um recurso limitado (um buffer de 7 posições). A comunicação e sincronização entre as threads são controladas por **semáforos** e um **mutex (ReentrantLock)**, garantindo exclusão mútua e evitando condições de corrida.

---

## Estrutura do Projeto

```
📂 produtor-consumidor
│
├── App.java              # Classe principal - executa o sistema
├── Buffer.java           # Recurso compartilhado (buffer limitado)
├── Produtor.java         # Thread produtora
├── Consumidor.java       # Thread consumidora
├── LogWriter.java        # Registra todas as ações em um arquivo de log
└── saida-log.txt         # Arquivo de saída com o histórico das operações
```

---

## Tecnologias Utilizadas

- Linguagem: **Java (JDK 11 ou superior)**
- Mecanismos de Sincronização:
  - **java.util.concurrent.Semaphore**
  - **java.util.concurrent.locks.ReentrantLock**
- Ferramentas de Log:
  - **java.io.BufferedWriter** e **FileWriter**

---

## Como Executar

1. **Certifique-se de ter o JDK instalado.**  
   Verifique com o comando:
   ```bash
   java -version
   ```

2. **Compile todos os arquivos Java:**
   ```bash
   javac *.java
   ```

3. **Execute a aplicação:**
   ```bash
   java App
   ```

4. **Verifique o log de execução:**
   Após a execução, o arquivo `saida-log.txt` será gerado na pasta do projeto.

---

## Funcionamento

- O **Produtor** tenta inserir itens no buffer em lotes de até 15 unidades.
- O **Consumidor** retira itens do buffer em lotes de até 12 unidades.
- Se o buffer estiver cheio, o produtor aguarda até que haja espaço disponível.
- Se o buffer estiver vazio, o consumidor aguarda até que novos itens sejam produzidos.
- Cada operação é registrada no log, indicando a ação executada e os espaços disponíveis no buffer.

Exemplo de saída do log:

```
2025-11-12T10:10:15.321 | Produtor  | Produtor-1   | Espaços disponíveis: 6
2025-11-12T10:10:15.372 | Produtor  | Produtor-2   | Espaços disponíveis: 5
2025-11-12T10:10:15.478 | Consumidor| Consumidor-1 | Espaços disponíveis: 6
2025-11-12T10:10:15.510 | Consumidor| Consumidor-2 | Espaços disponíveis: 7
```

---

## Conceitos Envolvidos

Este projeto aborda os seguintes conceitos de **Sistemas Operacionais**:

- **Threads e Processos:** execução simultânea de tarefas dentro de um mesmo programa.  
- **Sincronização:** controle de acesso ao recurso compartilhado (buffer).  
- **Semáforos:** contadores que coordenam o uso de espaços disponíveis e itens produzidos.  
- **Exclusão Mútua:** garantida pelo `ReentrantLock`, evitando que duas threads alterem o buffer simultaneamente.  
- **System Calls:** simuladas pela escrita em arquivo (`LogWriter`), representando operações de E/S.  
- **Escalonamento:** alternância de execução das threads, simulando a distribuição de tempo da CPU.  

---

## Resultado Esperado

O sistema deve executar sem interrupções ou conflitos de acesso, demonstrando a alternância correta entre produção e consumo, e a manutenção da integridade do buffer.

---

## Conclusão

Este projeto permitiu a aplicação prática de diversos conteúdos da disciplina de **Sistemas Operacionais**, como concorrência, gerenciamento de memória, sincronização e controle de E/S.  
A implementação em Java possibilitou observar, de forma concreta, como o sistema operacional organiza e coordena múltiplas atividades para garantir desempenho e segurança no acesso aos recursos.
