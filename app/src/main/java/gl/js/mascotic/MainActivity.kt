package gl.js.mascotic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Cursos(val nombre: String, val url: String)

class MainActivity : AppCompatActivity() {
    var react = Cursos("React", "react")
    var kotl = Cursos("Kotlin", "kotlin")
    var actual = react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurso("Curso de ${actual.nombre} en URL: ${actual.url}")
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            switchCurso(actual)
        }
    }

    private fun switchCurso (curso : Cursos) {
        var c = curso.copy()
        when(curso.url) {
            "react" -> c = kotl.copy()
            "kotlin" -> c = react.copy()
            else -> print("Mai pasara")
        }
        setCurso("Curso de ${c.nombre} en URL: ${c.url}")
    }

    private fun setCurso(s: String) {
        val texto = findViewById<TextView>(R.id.miss)
        texto.text = s
    }
}
