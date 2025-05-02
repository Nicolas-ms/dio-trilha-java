
#### Arquivo: `diagrama-uml.md`
```markdown
# Diagrama UML - iPhone

```mermaid
classDiagram
    class ReprodutorMusical {
        +tocar()
        +pausar()
        +selecionarMusica(musica: String)
    }
    class AparelhoTelefonico {
        +ligar(numero: String)
        +atender()
        +iniciarCorreioVoz()
    }
    class NavegadorInternet {
        +exibirPagina(url: String)
        +adicionarNovaAba()
        +atualizarPagina()
    }
    class IPhone {
    }
    IPhone ..|> ReprodutorMusical
    IPhone ..|> AparelhoTelefonico
    IPhone ..|> NavegadorInternet

![image](https://github.com/user-attachments/assets/1a7148f1-5209-4a44-b02a-4a4e1a557564)

