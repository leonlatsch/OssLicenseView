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

import com.google.gson.annotations.SerializedName

/**
 * Model representing an entry of the json report.
 *
 * @since 0.1.0
 * @author Leon Latsch
 */
internal data class OssEntry(
    val project: String,
    val description: String,
    val version: String,
    val developers: List<String>,
    val url: String,
    val year: String,
    val licenses: List<LicenseSubEntry>,
    val dependency: String
) {
    data class LicenseSubEntry(
        val license: String,
        @SerializedName("license_url") val licenseUrl: String
    )
}