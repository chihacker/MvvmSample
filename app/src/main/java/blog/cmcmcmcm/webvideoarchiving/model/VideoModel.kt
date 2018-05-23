package blog.cmcmcmcm.webvideoarchiving.model

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */


data class VideoItem(val id: Int,
                     val url: String,
                     val tags: MutableList<VideoTag>)

data class VideoTag(val id: Int,
               val text: String,
               val time: Long)