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

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * A Recycler View for displaying json reports from the plugin shown below.
 *
 * https://github.com/jaredsburrows/gradle-license-plugin
 *
 * @since 0.1.0
 * @author Leon Latsch
 */
class OssLicenseView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    fun initialize(fileName: String) {
        context.assets.open(fileName).let {
            val json = String(it.readBytes())
            val listType = object : TypeToken<ArrayList<OssEntry?>?>() {}.type
            val licenses: ArrayList<OssEntry> = Gson().fromJson(json, listType)

            layoutManager = LinearLayoutManager(context)
            adapter = OssAdapter(licenses)
        }
    }
}