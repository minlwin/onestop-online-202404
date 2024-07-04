package com.jdc.console.app.component;

import com.jdc.console.app.exceptions.InvalidComponentDataException;
import com.jdc.console.app.utils.FormatUtils;

public record TableViewData(
		ColumnAlignment [] columns,
		String [] headers,
		String [][] contents
		) {
	
	public TableViewData {
		
		if(null == columns || columns.length == 0) {
			throw new InvalidComponentDataException("Table View", "Columns length must not be empty.");
		}
		
		if(null == headers || headers.length == 0) {
			throw new InvalidComponentDataException("Table View", "Headers length must not be empty.");
		}
		
		if(columns.length != headers.length ) {
			throw new InvalidComponentDataException("Table View", "Columns length and Headers length must be same.");
		}
		
		for(var row : contents) {
			if(null != row && columns.length != row.length) {
				throw new InvalidComponentDataException("Table View", "Columns length and content data length must be same.");
			}
		}
	}

	public enum ColumnAlignment {
		Left {
			@Override
			public String format() {
				return FormatUtils.FMT_STRING;
			}
		}, Right {
			@Override
			public String format() {
				return FormatUtils.FMT_NUMBER;
			}
		};
		
		public abstract String format();
	}
}
