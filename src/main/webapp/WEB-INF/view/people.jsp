<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
Hi ${name}<br/>
<div>
<a type="button" class="btn btn-primary" href="/add-entity">Add</a></br>
<a type="button" class="btn btn-primary" href="/groups">Active</a>
<a type="button" class="btn btn-primary" href="/status">Inactive</a>
</div>

<div class= "container">
<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
    <thead>
        <tr>
            <th>Parent</th>
            <th>%Ownership</th>
            <th>Acquisition Date</th>
            <th>Last Updated</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <td>${parent.entity.legalName} </td>
            <td>${parent.percentage} </td>
            <td><fmt:formatDate pattern="MM/dd/yyyy"
				value="${entity.acquisitionDate}" /></td>
			<td>${parent.lastUpdated} </td>
		 </tr>
    </tbody>

</table>

</div>
<div class= "container">
<a type="button" class="btn btn-primary" href="/groups">Active</a>
<a type="button" class="btn btn-primary" href="/status">Inactive</a>

<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>

    <tbody>
        <tr>
            <td>${parent.entity.legalName} </td>
            <td>${parent.percentage} </td>
            <td><fmt:formatDate pattern="MM/dd/yyyy"
				value="${entity.acquisitionDate}" /></td>
			<td>${parent.lastUpdated} </td>
		 </tr>
    </tbody>

</table>
</div>
<%@ include file="common/footer.jspf"%>

