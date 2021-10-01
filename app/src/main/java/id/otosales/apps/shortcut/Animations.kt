package id.otosales.apps.shortcut

import android.animation.Animator
import android.view.View
import android.view.animation.Animation
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import id.otosales.apps.helper.GeneralHelper

class Animations {
    class Mode {
        companion object{
            const val HIDE_AFTER_ANIMATION_END = 1001
            const val SHOW_AFTER_ANIMATION_END = 1002
        }
    }

    companion object{
        fun play(view : View, techniques : Techniques, isRepeat : Boolean, mode : Int){
            YoYo.with(techniques)
                .duration(100)
                .withListener(object : Animator.AnimatorListener{
                    override fun onAnimationStart(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        if (mode == Mode.HIDE_AFTER_ANIMATION_END){
                            GeneralHelper.gone(view)
                        }else if (mode == Mode.SHOW_AFTER_ANIMATION_END){
                            GeneralHelper.visible(view)
                        }
                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                })
                .repeat(if (isRepeat) YoYo.INFINITE else 0 )
                .playOn(view)
        }
    }
}