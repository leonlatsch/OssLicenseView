/*
 *   Copyright 2021 - 2025 Leon Latsch
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package dev.leonlatsch.osslicenseview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for creating [OssViewHolder]s in [OssLicenseView].
 *
 * @since 0.1.0
 * @author Leon Latsch
 */
internal class OssAdapter(
    private val ossEntries: List<OssEntry>
) : RecyclerView.Adapter<OssViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OssViewHolder =
        OssViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.item_oss_entry, parent, false)
        )

    override fun onBindViewHolder(holder: OssViewHolder, position: Int) {
        holder.bindTo(ossEntries[position])
    }

    override fun getItemCount(): Int = ossEntries.size
}