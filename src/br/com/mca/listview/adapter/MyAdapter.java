package br.com.mca.listview.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.mca.listview.R;

/**
 * @author luis82fernandez
 */
public class MyAdapter extends BaseAdapter {

	private List<String> mList;
	private LayoutInflater mInflater;

	public MyAdapter(Context context, List<String> mList) {
		super();
		this.mInflater = LayoutInflater.from(context);
		this.mList = mList;
	}

	@Override
	public int getCount() {
		if (mList != null) {
			return mList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if (mList != null) {
			return mList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * Baseado no exemplo da classe com.example.android.apis.view.List14 do APIDemos
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// A ViewHolder keeps references to children views to
		// avoid unneccessary calls to findViewById() on each row.
		ViewHolder holder;

		// When convertView is not null, we can reuse it directly, there is no need
		// to reinflate it. We only inflate a new View when the convertView supplied
		// by ListView is null.
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.comp_listview_item, null);

			// Creates a ViewHolder and store references to the two children views
			// we want to bind data to.
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.compListView.textClubName);

			convertView.setTag(holder);
		} else {
			// Get the ViewHolder back to get fast access to the TextView
			// and the ImageView.
			holder = (ViewHolder) convertView.getTag();
		}

		// Bind the data efficiently with the holder.
		holder.textName.setText(mList.get(position));

		return convertView;
	}

	static class ViewHolder {
		TextView textName;
	}
}
