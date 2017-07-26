<p class="lead">Shop Name</p>
<div class="list-group">

	<c:forEach items="${categories}" var="category_item">
		<a href="${contextRoot}/show/category/${category_item.id}/products"
						 class="list-group-item" id="a_${category_item.name}">${category_item.name}</a>
	</c:forEach>
	
</div>