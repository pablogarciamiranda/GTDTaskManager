package uo.sdi.business.impl.command;

import uo.sdi.business.exception.BusinessException;

public class CommandExecutor<T> {

	public T execute(Command<T> cmd) throws BusinessException {
		return cmd.execute();
	}

}
