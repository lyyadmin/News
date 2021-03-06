package com.lianqiang.badnews.data.retrofit.apiservice;

import com.lianqiang.badnews.module.news.bean.NewsDetail;
import com.lianqiang.badnews.module.news.bean.NewsList;
import com.lianqiang.badnews.module.video.bean.VideoList;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * TODO 新闻接口
 * Created by lianqiang on 2017/5/17.
 */

public interface RetrofitNewsService {

    /**
     * 请求新闻列表 例子：http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
     *
     * @param type      新闻类别：headline为头条,local为北京本地,fangchan为房产,list为其他
     * @param id        新闻类别id
     * @param startPage 开始的页码
     * @return 被观察对象
     */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsList>>> getNewsList(
            @Path("type") String type,
            @Path("id") String id,
            @Path("startPage") int startPage);

    /**
     * 新闻详情：例子：http://c.m.163.com/nc/article/BFNFMVO800034JAU/full.html
     *
     * @param postId 新闻详情的id
     * @return 被观察对象
     */
    @GET("nc/article/{postId}/full.html")
    Observable<Map<String, NewsDetail>> getNewsDetail(
            @Path("postId") String postId);

    /**
     * 视频列表 例子：http://c.m.163.com/nc/video/list/V9LG4B3A0/n/0-10.html
     *
     * @param id        视频类别id
     * @param startPage 开始的页码
     * @return 被观察者
     */
    @GET("nc/video/list/{id}/n/{startPage}-10.html")
    Observable<Map<String, List<VideoList>>> getVideoList(
            @Path("id") String id,
            @Path("startPage") int startPage);

}
