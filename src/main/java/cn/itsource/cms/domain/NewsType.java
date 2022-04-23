package cn.itsource.cms.domain;

import java.io.Serializable;
import java.sql.Savepoint;

public class NewsType implements Serializable {
  private Long id;//  新闻类型id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    private String name;//新闻类型名字
    @Override
    public String toString() {
        return "NewsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
