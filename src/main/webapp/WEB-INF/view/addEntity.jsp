<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add Entity </h1>

<form:form method="post" modelAttribute="entity" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <fieldset class="form-group">
        <form:label path="legalName">Legal Name: </form:label>
        <form:input type="text" path="legalName" class="form-control" required="required"/>
        <form:errors path="legalName" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="jurisdiction">Jurisdiction </form:label>
        <form:input type="text" path="jurisdiction" class="form-control" />
        <form:errors path="jurisdiction" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="formOfOrganization">Form of Organization </form:label>
        <form:input type="text" path="formOfOrganization" class="form-control" />
        <form:errors path="formOfOrganization" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group" >
        <form:label path="file">Choose File </form:label>
        <form:input type="file" path="file" class="form-control"/>
        <form:errors path="file" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="legalAddress">Legal Address </form:label>
        <form:input type="text" path="legalAddress" class="form-control" />
        <form:errors path="legalAddress" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="headQSameAsLegal">is HeadQuarters address same as Legal address?</form:label>
        <form:radiobutton path="headQSameAsLegal" value="Yes" /> Yes
        <form:radiobutton path="headQSameAsLegal" value="No" /> No
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="headquartersAddress">HeadQuarters Address </form:label>
        <form:input type="text" path="headquartersAddress" class="form-control"/>
        <form:errors path="headquartersAddress" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="registeredAgent">Registered Agent </form:label>
        <form:input type="text" path="registeredAgent" class="form-control"/>
        <form:errors path="registeredAgent" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="incorporationDate">Incorporation Date:</form:label>
        <form:input type="text" path="incorporationDate"
            class="form-control"/>
        <form:errors path="incorporationDate" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
            <form:label path="otherNames">Other Names </form:label>
            <form:input type="text" path="registeredAgent" class="form-control"/>
            <form:errors path="registeredAgent" cssClass="text-warning" />
        </fieldset><br/>

        <fieldset class="form-group">
            <form:label path="tags">Tags </form:label>
            <form:input type="text" path="tags" class="form-control" />
            <form:errors path="tags" cssClass="text-warning" />
        </fieldset><br/>

        <fieldset class="form-group">
            <form:label path="groups">Groups </form:label>
            <form:input type="text" path="groups" class="form-control"/>
            <form:errors path="groups" cssClass="text-warning" />
        </fieldset><br/>

         <fieldset class="form-group">
            <form:label path="notes">Notes </form:label>
            <form:input type="text" path="notes" class="form-control"/>
            <form:errors path="notes" cssClass="text-warning" />
        </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="status">Status:</form:label>
        <form:input type="text" path="status" class="form-control"/>
    </fieldset><br/>

    <button type="submit" class="btn btn-success">Submit</button>
</form:form>
</div>
<%@ include file="common/footer.jspf"%>