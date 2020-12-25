<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add Ownership </h1>
<form:form method="post" modelAttribute="document" >
    <form:hidden path="id"/>
    <fieldset class="form-group">
        <form:label path="folder">Folder</form:label>
        <form:input type="text" path="folder" class="form-control" required="required"/>
        <form:errors path="folder" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="title">Title</form:label>
        <form:input type="text" path="title" class="form-control" />
        <form:errors path="title" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="jurisdiction">Jurisdiction</form:label>
        <form:input type="text" path="jurisdiction" class="form-control" />
        <form:errors path="jurisdiction" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="type">Type</form:label>
        <form:input type="text" path="type" class="form-control" />
        <form:errors path="type" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="uploadOrLink">Upload or Link?</form:label>
        <form:radiobutton path="uploadOrLink" value="true" /> Upload
        <form:radiobutton path="uploadOrLink" value="false" /> Link
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="file">Choose File </form:label>
        <form:input type="file" path="file" class="form-control"/>
        <form:errors path="file" cssClass="text-warning" />
    </fieldset><br/>

    <fieldset class="form-group">
        <form:label path="date">Date</form:label>
        <form:input type="text" path="date" class="form-control"/>
        <form:errors path="date" cssClass="text-warning" />
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