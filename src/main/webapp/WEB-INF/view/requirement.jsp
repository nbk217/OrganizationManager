<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
Hi ${name}<br/>
<div>
<a type="button" class="btn btn-success" href="/add-entity">Add</a></br>
<a type="button" class="btn btn-primary" href="/add-entity">Annual Reports/Statements</a>
<a type="button" class="btn btn-primary" href="/groups">Other Requirements</a></br>
</div>

<div class= "container">
<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
    <thead>
        <tr>
            <th>Summary</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <td>${requirement.summary} </td>
		 </tr>
    </tbody>

</table>
</div>
<%@ include file="common/footer.jspf"%>

