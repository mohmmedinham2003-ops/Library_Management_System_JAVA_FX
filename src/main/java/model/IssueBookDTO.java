package model;

import java.time.LocalDate;

public class IssueBookDTO {
    private Integer cmbMemberId;
    private Integer cmbBookId;
    private LocalDate dtpIssueDate;
    private LocalDate dtpDueDate;

    public IssueBookDTO(Integer cmbMemberId, Integer cmbBookId, LocalDate dtpIssueDate, LocalDate dtpDueDate) {
        this.cmbMemberId = cmbMemberId;
        this.cmbBookId = cmbBookId;
        this.dtpIssueDate = dtpIssueDate;
        this.dtpDueDate = dtpDueDate;
    }

    public IssueBookDTO() {
    }

    @Override
    public String toString() {
        return "IssueBookDTO{" +
                "cmbMemberId=" + cmbMemberId +
                ", cmbBookId=" + cmbBookId +
                ", dtpIssueDate=" + dtpIssueDate +
                ", dtpDueDate=" + dtpDueDate +
                '}';
    }

    public Integer getCmbMemberId() {
        return cmbMemberId;
    }

    public void setCmbMemberId(Integer cmbMemberId) {
        this.cmbMemberId = cmbMemberId;
    }

    public Integer getCmbBookId() {
        return cmbBookId;
    }

    public void setCmbBookId(Integer cmbBookId) {
        this.cmbBookId = cmbBookId;
    }

    public LocalDate getDtpIssueDate() {
        return dtpIssueDate;
    }

    public void setDtpIssueDate(LocalDate dtpIssueDate) {
        this.dtpIssueDate = dtpIssueDate;
    }

    public LocalDate getDtpDueDate() {
        return dtpDueDate;
    }

    public void setDtpDueDate(LocalDate dtpDueDate) {
        this.dtpDueDate = dtpDueDate;
    }
}
