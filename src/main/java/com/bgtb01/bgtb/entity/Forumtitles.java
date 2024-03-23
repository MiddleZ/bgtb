package com.bgtb01.bgtb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public class Forumtitles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TitleID", type = IdType.AUTO)
    private Integer titleID;

    private String titleContent;

    private LocalDateTime publishTime;

    private String originalLink;

    private Integer postHeat;

    private String category;

    private Double emotionIndex;

    private Integer universityID;

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public Integer getPostHeat() {
        return postHeat;
    }

    public void setPostHeat(Integer postHeat) {
        this.postHeat = postHeat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getEmotionIndex() {
        return emotionIndex;
    }

    public void setEmotionIndex(Double emotionIndex) {
        this.emotionIndex = emotionIndex;
    }

    public Integer getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Integer universityID) {
        this.universityID = universityID;
    }

    @Override
    public String toString() {
        return "Forumtitles{" +
            "titleID = " + titleID +
            ", titleContent = " + titleContent +
            ", publishTime = " + publishTime +
            ", originalLink = " + originalLink +
            ", postHeat = " + postHeat +
            ", category = " + category +
            ", emotionIndex = " + emotionIndex +
            ", universityID = " + universityID +
        "}";
    }
}
