package com.hcl.questionandanswermodule.model.dto.requestDto;

public class AnswersApproveDTO {
    private int answersId;
    private int status;

    public AnswersApproveDTO(int answersId, int status) {
        this.answersId = answersId;
        this.status = status;
    }

    public AnswersApproveDTO() {
    }

    public int getAnswersId() {
        return answersId;
    }

    public void setAnswersId(int answersId) {
        this.answersId = answersId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
