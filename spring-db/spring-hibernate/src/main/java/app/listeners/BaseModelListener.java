package app.listeners;

import java.util.Date;

import javax.persistence.PreUpdate;

import app.models.BaseModel;

public class BaseModelListener {

    @PreUpdate
    public static void preUpdate(BaseModel baseModel) {

	baseModel.lastModifyTime = new Date();
    }

}
