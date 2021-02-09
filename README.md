# Caixa Eletronico
## Microserviço destinado para aporte de valores no saldo da aposentadoria.

- Necessário estar com o microserviço de beneficiário levantado, o gradle versão 6.7 e a JDK 11.

- Documentação disponível em: http://localhost:8081/swagger-ui.html

- Para aportar valor necessário um POST em: http://localhost:8081/aporte
Com o json body:

        `{
            "id_beneficiario": 12,
            "valor_aporte": 21
        }`
