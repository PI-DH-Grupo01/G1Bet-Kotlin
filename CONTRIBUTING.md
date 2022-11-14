# Como contribuir? 

* Caso seja um colaborador externo, dê um fork no projeto.
* A criação de branches deve seguir a política de branches.
* O desenvolvimento deve seguir nossa política de commits.

# Políticas de branches

Nossas branches vão seguir os seguintes modelos para uma melhor organização das atividades.

## main

A main é a nossa branch de produção, é nela que vai ficar a versão estável do projeto.

## develop
A develop é a branch de desenvolvimento, é nela que onde vai ser enviado os trabalhos feitos nas outras branches de features, hotfix, etc, ou seja, ela possui os códigos que ainda não foram publicadas e que posteriormente vão ser mergeados com a **main**.

## branches de features

As branches de features são criadas a partir da **develop**, e servem para o desenvolvimento de features do projeto. Após a conclusão das atividades feitas na branch, ela deve ser enviada para **develop** através de um pull request.

## branches de hotfix 

As branches de hotfix são criadas a partir da **main** para resolver de forma rápida algum bug ou pequenos erros em produção.

## banches de configuration

As branches de configuration são criadas para adicionar configurações referentes a algum tipo de ferramenta que ajude no desenvolvimento do projeto.

## Padrão de nomes das branches

As branches devem seguir o seguinte padrão:

* feature/nome_da_brach
* hotfix/nome_da_brach
* configuration/nome_da_brach

# Políticas de commit

Os commits devem descrever de forma simples e clara o que foi feito. E devem ser escritos em português para compreensão de todos.
