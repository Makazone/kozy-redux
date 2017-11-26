package com.github.rozag.redux.notes.screen.edit

import android.os.Bundle
import com.github.rozag.redux.notes.AppState
import com.github.rozag.redux.notes.R
import com.github.rozag.redux.notes.ReduxActivity
import com.github.rozag.redux.notes.statusBarHeight

class EditActivity : ReduxActivity() {

    override val layoutResourceId = R.layout.activity_edit
    override val toolbarTitleId = R.string.edit_note
    override val displayHomeAsUp = true
    override val homeButtonEnabled = true

    private var isExiting = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar?.apply {
            setPadding(
                    paddingLeft,
                    resources.statusBarHeight(),
                    paddingRight,
                    paddingBottom
            )
        }
    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_right)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        isExiting = true
        store.dispatch(EditAction.TearDown())
    }

    override fun onNewState(state: AppState) {
        super.onNewState(state)

        if (isExiting) {
            return
        }

        // TODO
    }

}