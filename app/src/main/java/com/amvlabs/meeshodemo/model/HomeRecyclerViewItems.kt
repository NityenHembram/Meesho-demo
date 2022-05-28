package com.amvlabs.meeshodemo.model

sealed class HomeRecyclerViewItems {
  data class LayoutItems(val spanSize:String,val title:String,val list:List<ChildRecyclerViewItems>):HomeRecyclerViewItems()
  data class ViewPagerLayoutItem(val spanSize:String,val title:String,val list:List<ChildRecyclerViewItems>):HomeRecyclerViewItems()

}