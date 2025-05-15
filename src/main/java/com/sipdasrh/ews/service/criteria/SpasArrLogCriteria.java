package com.sipdasrh.ews.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.sipdasrh.ews.domain.SpasArrLog} entity. This class is used
 * in {@link com.sipdasrh.ews.web.rest.SpasArrLogResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /spas-arr-logs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SpasArrLogCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter timeLog;

    private ZonedDateTimeFilter timeRetrieve;

    private StringFilter logValue;

    private LongFilter spasArrInstallId;

    private Boolean distinct;

    public SpasArrLogCriteria() {}

    public SpasArrLogCriteria(SpasArrLogCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.timeLog = other.optionalTimeLog().map(ZonedDateTimeFilter::copy).orElse(null);
        this.timeRetrieve = other.optionalTimeRetrieve().map(ZonedDateTimeFilter::copy).orElse(null);
        this.logValue = other.optionalLogValue().map(StringFilter::copy).orElse(null);
        this.spasArrInstallId = other.optionalSpasArrInstallId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public SpasArrLogCriteria copy() {
        return new SpasArrLogCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getTimeLog() {
        return timeLog;
    }

    public Optional<ZonedDateTimeFilter> optionalTimeLog() {
        return Optional.ofNullable(timeLog);
    }

    public ZonedDateTimeFilter timeLog() {
        if (timeLog == null) {
            setTimeLog(new ZonedDateTimeFilter());
        }
        return timeLog;
    }

    public void setTimeLog(ZonedDateTimeFilter timeLog) {
        this.timeLog = timeLog;
    }

    public ZonedDateTimeFilter getTimeRetrieve() {
        return timeRetrieve;
    }

    public Optional<ZonedDateTimeFilter> optionalTimeRetrieve() {
        return Optional.ofNullable(timeRetrieve);
    }

    public ZonedDateTimeFilter timeRetrieve() {
        if (timeRetrieve == null) {
            setTimeRetrieve(new ZonedDateTimeFilter());
        }
        return timeRetrieve;
    }

    public void setTimeRetrieve(ZonedDateTimeFilter timeRetrieve) {
        this.timeRetrieve = timeRetrieve;
    }

    public StringFilter getLogValue() {
        return logValue;
    }

    public Optional<StringFilter> optionalLogValue() {
        return Optional.ofNullable(logValue);
    }

    public StringFilter logValue() {
        if (logValue == null) {
            setLogValue(new StringFilter());
        }
        return logValue;
    }

    public void setLogValue(StringFilter logValue) {
        this.logValue = logValue;
    }

    public LongFilter getSpasArrInstallId() {
        return spasArrInstallId;
    }

    public Optional<LongFilter> optionalSpasArrInstallId() {
        return Optional.ofNullable(spasArrInstallId);
    }

    public LongFilter spasArrInstallId() {
        if (spasArrInstallId == null) {
            setSpasArrInstallId(new LongFilter());
        }
        return spasArrInstallId;
    }

    public void setSpasArrInstallId(LongFilter spasArrInstallId) {
        this.spasArrInstallId = spasArrInstallId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SpasArrLogCriteria that = (SpasArrLogCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(timeLog, that.timeLog) &&
            Objects.equals(timeRetrieve, that.timeRetrieve) &&
            Objects.equals(logValue, that.logValue) &&
            Objects.equals(spasArrInstallId, that.spasArrInstallId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeLog, timeRetrieve, logValue, spasArrInstallId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SpasArrLogCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTimeLog().map(f -> "timeLog=" + f + ", ").orElse("") +
            optionalTimeRetrieve().map(f -> "timeRetrieve=" + f + ", ").orElse("") +
            optionalLogValue().map(f -> "logValue=" + f + ", ").orElse("") +
            optionalSpasArrInstallId().map(f -> "spasArrInstallId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
