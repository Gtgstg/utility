package com.hashedin.utility

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class CustomSwipeAdapter() : PagerAdapter(), Parcelable {
    val image_resources= arrayOf(R.drawable.carousel1,R.drawable.carousel2,R.drawable.carousel3)
    lateinit var ctx:Context
    lateinit var layoutInflater: LayoutInflater

    constructor(parcel: Parcel) : this() {

    }

    //    constructor(ctx: Context):this(CustomSwipeAdapter()){
//        this.ctx=ctx
//    }
    constructor(ctx:Context) : this(){
        this.ctx=ctx
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object` as LinearLayout
    }

    override fun getCount(): Int {
        return image_resources.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater= ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val item_view:View=layoutInflater.inflate(R.layout.swipe_layout,container,false)
        val image_view=item_view.findViewById(R.id.image_view) as ImageView
        image_view.setImageResource(image_resources[position])
        container.addView(item_view)
        return item_view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CustomSwipeAdapter> {
        override fun createFromParcel(parcel: Parcel): CustomSwipeAdapter {
            return CustomSwipeAdapter(parcel)
        }

        override fun newArray(size: Int): Array<CustomSwipeAdapter?> {
            return arrayOfNulls(size)
        }
    }
}