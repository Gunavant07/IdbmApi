package com.example.idbmapi.Retrofit

import com.google.gson.annotations.SerializedName

data class Modeldata(

	@field:SerializedName("q")
	val q: String? = null,

	@field:SerializedName("d")
	val d: List<DItem?>? = null,

	@field:SerializedName("v")
	val v: Int? = null
)

data class DItem(

	@field:SerializedName("q")
	val q: String? = null,

	@field:SerializedName("s")
	val s: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("y")
	val y: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("l")
	val l: String? = null,

	@field:SerializedName("qid")
	val qid: String? = null,

	@field:SerializedName("i")
	val i: I? = null,

	@field:SerializedName("yr")
	val yr: String? = null
)

data class I(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
