/*
 *   Copyright 2021 Leon Latsch
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

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Maps [OssEntry] to the item view.
 *
 * @since 0.1.0
 * @author Leon Latsch
 */
internal class OssViewHolder(
    private val context: Context,
    view: View
) : RecyclerView.ViewHolder(view) {

    private val licenseGeneral = itemView.findViewById<LinearLayout>(R.id.itemOssGeneral)
    private val project = itemView.findViewById<AppCompatTextView>(R.id.itemOssProject)
    private val version = itemView.findViewById<AppCompatTextView>(R.id.itemOssVersion)
    private val license = itemView.findViewById<AppCompatTextView>(R.id.itemOssLicense)

    private val licenseDetails = itemView.findViewById<LinearLayout>(R.id.itemOssDetails)
    private val packageName = itemView.findViewById<AppCompatTextView>(R.id.itemOssPackageName)
    private val copyright = itemView.findViewById<AppCompatTextView>(R.id.itemOssCopyright)

    fun bindTo(ossEntry: OssEntry) {
        project.text = ossEntry.project
        version.text = ossEntry.version
        packageName.text = ossEntry.dependency

        licenseGeneral.setOnClickListener {
            openUrl(context, ossEntry.url)
        }

        ossEntry.licenses.firstOrNull()?.let {
            copyright.text = COPYRIGHT
                .replace(COPYRIGHT_YEAR_PLACEHOLDER, ossEntry.year ?: COPYRIGHT_YEAR_DEFAULT)
                .replace(COPYRIGHT_AUTHOR_PLACEHOLDER, ossEntry.developers.firstOrNull() ?: COPYRIGHT_AUTHOR_DEFAULT)

            license.text = it.license
            licenseDetails.setOnClickListener { _ ->
                openUrl(context, it.licenseUrl)
            }
        }
    }

    companion object {

        private const val COPYRIGHT_AUTHOR_PLACEHOLDER = "{author}"
        private const val COPYRIGHT_AUTHOR_DEFAULT = "The original authors"

        private const val COPYRIGHT_YEAR_PLACEHOLDER = "{year}"
        private const val COPYRIGHT_YEAR_DEFAULT = "20XX"

        private const val COPYRIGHT = "Copyright (c) $COPYRIGHT_YEAR_PLACEHOLDER $COPYRIGHT_AUTHOR_PLACEHOLDER"

    }
}