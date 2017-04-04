package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.command.Command;
import uo.sdi.infraestructure.Factories;

public class DeleteCategoryCommand implements Command<Void> {

	private Long catId;

	public DeleteCategoryCommand(Long catId) {
		this.catId = catId;
	}

	@Override
	public Void execute() throws BusinessException {
		Factories.persistence.getTaskDao().deleteAllFromCategory( catId );
		Factories.persistence.getCategoryDao().delete( catId );
		return null;
	}

}
