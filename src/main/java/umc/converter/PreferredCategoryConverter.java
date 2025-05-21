package umc.converter;

import java.util.List;

import umc.domain.Category;
import umc.domain.mapping.PreferredCategory;

public class PreferredCategoryConverter {

	public static List<PreferredCategory> toPreferredCategoryList(List<Category> categoryList) {
		return categoryList.stream()
			.map(category ->
					PreferredCategory.builder()
						.category(category)
						.build()
				).toList();
	}
}
