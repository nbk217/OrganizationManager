<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
${name}<br/>

<div class= "container">
<table class="table table-striped ">
    <caption>Documents</caption>
    <thead>
        <tr>
            <th>Folder</th>
            <th>Title</th>
            <th>Type</th>
            <th>Entity</th>
            <th>Jurisdiction</th>
            <th>File</th>
            <th>Date</th>
            <th>Notes</th>
        </tr>
    </thead>

    <tbody>
       <c:forEach items="${documents}" var="doc">
               <tr>
                   <td>${doc.folder} </td>
                   <td>${doc.title} </td>
                   <td>${doc.type} </td>
                   <td>${doc.entity.legalName} </td>
                   <td>${doc.jurisdiction} </td>
                   <td>${doc.file.originalFilename} </td>
                   <td><fmt:formatDate pattern="MM/dd/yyyy"
       				value="${doc.date}" /></td>
       			<td>${doc.notes} </td>
       		 </tr>
       </c:forEach>
    </tbody>

</table>

<div class="container">
<a type="button" class="btn btn-success" href="/add-document?entityId=${entityId}">Add a Document</a>
</div>
</div>
<%@ include file="common/footer.jspf"%>

