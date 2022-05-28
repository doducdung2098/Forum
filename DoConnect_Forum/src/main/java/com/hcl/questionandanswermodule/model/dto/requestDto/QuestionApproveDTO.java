package com.hcl.questionandanswermodule.model.dto.requestDto;

public class QuestionApproveDTO {
    private int questionId;
    private int status;

    public QuestionApproveDTO() {
    }

    public QuestionApproveDTO(int questionId, int status) {
        this.questionId = questionId;
        this.status = status;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
