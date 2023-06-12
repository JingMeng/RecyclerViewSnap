package com.github.rubensousa.recyclerviewsnap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.rubensousa.recyclerviewsnap.R
import com.github.rubensousa.recyclerviewsnap.model.App

/**
 * MaterialCardView 这个是一个好东西？ 阴影是这个里面导致的吗？
 *
 *  https://juejin.cn/post/6844903946071343118
 *
 *  adapter2 是没有效果的
 *
 *   加上 android:background="?attr/selectableItemBackground" 就有效果了
 *
 *   https://www.jianshu.com/p/13eb4574e988
 *
 *  adapter3 是存在效果的
 *  adapter4 是存在效果的
 *
 *
 *  dispatchDraw
 *
 *  RippleDrawable#draw
 *
 *  https://www.jianshu.com/p/64a825915da9
 *
 *  https://blog.csdn.net/qq_25452989/article/details/87280873
 *
 * https://blog.csdn.net/mjlong123123/article/details/88983884
 *
 *
 * https://juejin.cn/s/android%20imageview%20%E8%AE%BE%E7%BD%AE%E8%BE%B9%E6%A1%86
 *
 *
 * https://www.zybuluo.com/act262/note/572262
 *
 * 
 */
class AppAdapter(private val layoutId: Int = R.layout.adapter2) :
    RecyclerView.Adapter<AppAdapter.VH>() {

    private var items = listOf<App>()

    fun setItems(list: List<App>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(
                parent.context
            ).inflate(layoutId, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    class VH(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)

        init {
            //这个点击能够让前置阴影是否出现
            view.setOnClickListener(this)
        }

        fun bind(app: App) {
            imageView.setImageResource(app.drawable)
            nameTextView.text = app.name
            ratingTextView.text = app.rating.toString()
        }

        override fun onClick(v: View?) {

        }
    }
}
