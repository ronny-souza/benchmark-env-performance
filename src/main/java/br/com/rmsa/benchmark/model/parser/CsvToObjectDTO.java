package br.com.rmsa.benchmark.model.parser;

import com.opencsv.bean.CsvBindByPosition;

public class CsvToObjectDTO {
    private @CsvBindByPosition(position = 0) String seriesReference;
    private @CsvBindByPosition(position = 1) String period;
    private @CsvBindByPosition(position = 2) String dataValue;
    private @CsvBindByPosition(position = 3) String suppressed;
    private @CsvBindByPosition(position = 4) String status;
    private @CsvBindByPosition(position = 5) String units;
    private @CsvBindByPosition(position = 6) String magnitude;
    private @CsvBindByPosition(position = 7) String subject;
    private @CsvBindByPosition(position = 8) String group;
    private @CsvBindByPosition(position = 9) String seriesTitle;

    public String getSeriesReference() {
        return seriesReference;
    }

    public void setSeriesReference(String seriesReference) {
        this.seriesReference = seriesReference;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getSuppressed() {
        return suppressed;
    }

    public void setSuppressed(String suppressed) {
        this.suppressed = suppressed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }
}
