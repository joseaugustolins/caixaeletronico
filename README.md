# Caixa Eletronico
## Microserviço destinado para aporte de valores no saldo da aposentadoria. Ele envia o código do beneficiário e o valor a ser aportado para um fila (que é consumida pelo serviço de gerenciamento de beneficiáro) e ao enviar essa quantia, o sistema busca as informações do beneficiário e já informa o valor atualizado que será recebido.

- Necessário estar com o microserviço de beneficiário levantado, o gradle versão 6.7 e a JDK 11.

- Documentação disponível em: http://localhost:8081/swagger-ui.html

- Para aportar valor necessário um POST em: http://localhost:8081/aporte
Com o json body:

        `{
            "id_beneficiario": 12,
            "valor_aporte": 21
        }`
