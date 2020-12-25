<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add Ownership </h1>
<form:form method="post" modelAttribute="ownership" >
    <form:hidden path="id"/>
    <fieldset class="form-group">
        <form:label path="type">Type </form:label>
        <form:input type="text" path="type" class="form-control" required="required"/>
        <form:errors path="type" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="entity.legalName">Entity </form:label>
        <form:input type="text" path="entity.legalName" class="form-control" />
        <form:errors path="entity.legalName" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="percentage">Ownership Percentage </form:label>
        <form:input type="text" path="percentage" class="form-control" />
        <form:errors path="percentage" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="acquisitionDate">Acquisition Date </form:label>
        <form:input type="text" path="acquisitionDate" class="form-control" />
        <form:errors path="acquisitionDate" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="dispositionDate">Disposition Date</form:label>
        <form:input type="text" path="dispositionDate" class="form-control"/>
        <form:errors path="dispositionDate" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="status">Status </form:label>
        <form:input type="text" path="status" class="form-control"/>
        <form:errors path="status" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="notes">Notes</form:label>
        <form:input type="text" path="notes" class="form-control"/>
        <form:errors path="notes" cssClass="text-warning" />
    </fieldset><br/>

    <button type="submit" class="btn btn-success">Submit</button>
    <a href="/entitydetails">Cancel</a>
</form:form>
</div>
<%@ include file="common/footer.jspf"%>