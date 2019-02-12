package br.com.caelum.casadocodigo.activity


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigo.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ItemWithScrooling {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun itemWithScrooling() {
        val recyclerView = onView(allOf(withId(R.id.lista_livros)))
        Thread.sleep(5000)

        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(8, click()))

        var appCompatButton = onView(allOf(withId(R.id.detalhes_livro_comprar_ebook)))

        appCompatButton.perform(click())

        pressBack()

        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        appCompatButton = onView(allOf(withId(R.id.detalhes_livro_comprar_ebook)))

        appCompatButton.perform(click())

        pressBack()

        val actionMenuItemView = onView(allOf(withId(R.id.vai_para_carrinho)))

        actionMenuItemView.perform(click())
    }
}
