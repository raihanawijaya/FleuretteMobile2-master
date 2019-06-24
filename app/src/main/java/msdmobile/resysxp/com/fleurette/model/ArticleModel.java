package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleModel {
    @SerializedName("article_code")
    @Expose
    private String articleCode;
    @SerializedName("article_name")
    @Expose
    private String articleName;
    @SerializedName("article_stock")
    @Expose
    private Integer articleStock;
    @SerializedName("article_price")
    @Expose
    private Integer articlePrice;

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Integer getArticleStock() {
        return articleStock;
    }

    public void setArticleStock(Integer articleStock) {
        this.articleStock = articleStock;
    }

    public Integer getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(Integer articlePrice) {
        this.articlePrice = articlePrice;
    }
}
