package de.metas.ui.web.base.model;

/*
 * #%L
 * de.metas.ui.web.base
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

public interface I_T_WEBUI_ViewSelectionLine
{
	String Table_Name = "T_WEBUI_ViewSelectionLine";

	String COLUMNNAME_UUID = "UUID";

	/** Record ID / Aggregate record ID / Root record ID */
	String COLUMNNAME_Record_ID = "Record_ID";

	/** Line ID / Included record ID */
	String COLUMNNAME_Line_ID = "Line_ID";
}
