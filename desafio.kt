enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val nome: String, val email: String, val telefone: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, var nivel:Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }

    fun dados_alunos(aluno : Usuario){
        if(aluno in inscritos){
            println("Nome: ${aluno.nome}\nEmail cadastrado: ${aluno.email}\n telefone: ${aluno.telefone} ")
        }
    }

    fun conteudosFormacao(){
        println("Conteúdos do curso: ")
        for(conteudo in conteudos){
            println("${conteudo.nome}, com duração de ${conteudo.duracao} horas e de nível ${conteudo.nivel}") 
        }
    }

    fun ListarInscritos(){
        println("Números de alunos inscritos: ${inscritos.size}")
        for(aluno in inscritos){
            println(aluno.nome)
        } 
    }
}

fun main(){
    val moduloKotlin = ConteudoEducacional("Programação com Kotlin",180, Nivel.BASICO)
    val moduloJava = ConteudoEducacional("POO utilizando java", 200, Nivel.INTERMEDIARIO)
    val moduloVersionamento = ConteudoEducacional("Versionamento utilizando Git",12, Nivel.BASICO)
    
    val listaConteudos = mutableListOf<ConteudoEducacional>()
        listaConteudos.add(moduloKotlin)
        listaConteudos.add(moduloJava)
        listaConteudos.add(moduloVersionamento)

    val venilton = Usuario("Venilton","venilton@gmail.com", "(81)98080-8080")
    val jose = Usuario("Jose","jose1@hotmail.com","(85)99090-9090")
    val paula = Usuario("Paula", "paula@dio.com", "(75)91010-1010")

    val formacaoKotlin = Formacao("Formação Back-end utilizando Kotlin e Java",listaConteudos, Nivel.INTERMEDIARIO)

    formacaoKotlin.matricular(venilton)
    formacaoKotlin.matricular(jose)
    formacaoKotlin.matricular(paula)

    println("${formacaoKotlin.nome} - ${formacaoKotlin.nivel}")
    println("****************************************")

    formacaoKotlin.conteudosFormacao()
    println("****************************************")

    formacaoKotlin.ListarInscritos()
    println("****************************************")

    println("Dados dos usuários cadastrados: ")
    formacaoKotlin.dados_alunos(venilton)
    println("****************************************")
    formacaoKotlin.dados_alunos(jose)
    println("****************************************")
    formacaoKotlin.dados_alunos(paula)
}
