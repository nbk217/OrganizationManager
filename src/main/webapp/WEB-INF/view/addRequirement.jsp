<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add Requirement </h1>
<form:form method="post" modelAttribute="requirement" >
    <form:hidden path="id"/>
    <fieldset class="form-group">
        <form:label path="summary">Summary </form:label>
        <form:input type="text" path="summary" class="form-control" required="required"/>
        <form:errors path="summary" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="jurisdiction">Jurisdiction </form:label>
        <form:input type="text" path="jurisdiction" class="form-control" />
        <form:errors path="jurisdiction" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="type">Type </form:label>
        <form:input type="text" path="type" class="form-control" />
        <form:errors path="type" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="details">Details </form:label>
        <form:input type="text" path="details" class="form-control" />
        <form:errors path="details" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="notes">Notes </form:label>
        <form:input type="text" path="notes" class="form-control" />
        <form:errors path="notes" cssClass="text-warning" />
    </fieldset><br/>


    <fieldset class="form-group">
        <form:label path="dueDate">Due Date</form:label>
        <form:input type="text" path="dueDate" class="form-control"/>
        <form:errors path="dueDate" cssClass="text-warning" />
    </fieldset><br/>

    <button type="submit" class="btn btn-success">Submit</button>
    <a href="/entitydetails">Cancel</a>
</form:form>
</div>
<%@ include file="common/footer.jspf"%>