package de.metas.lock.api.impl;

/*
 * #%L
 * de.metas.async
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.ad.trx.spi.TrxListenerAdapter;
import org.adempiere.util.Services;

import de.metas.lock.api.ILock;
import de.metas.lock.api.ILockAutoCloseable;

/**
 * An {@link ILockAutoCloseable} implementation which when {@link #close()} is called it will
 * <ul>
 * <li>if transaction is null or no longer exist, it will close the lock immediatelly
 * <li>if transaction exists, it will close the lock asynchronously when the transaction is commited or rolled back.
 * </ul>
 *
 * @author tsa
 */
/* package */final class LockAutoCloseableOnTrxClose extends AbstractLockAutoCloseable
{
	private final String trxName;

	/* package */LockAutoCloseableOnTrxClose(final ILock lock, final String trxName)
	{
		super(lock);
		this.trxName = trxName;
	}

	@Override
	protected void closeImpl()
	{
		Services.get(ITrxManager.class)
				.getTrxListenerManagerOrAutoCommit(trxName)
				.registerListener(new TrxListenerAdapter()
				{
					@Override
					public void afterClose(ITrx trx)
					{
						closeNow();
					}
				});
	}
}
