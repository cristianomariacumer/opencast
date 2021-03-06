/**
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 *
 * The Apereo Foundation licenses this file to you under the Educational
 * Community License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at:
 *
 *   http://opensource.org/licenses/ecl2.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package org.opencastproject.publication.api;

import org.opencastproject.job.api.Job;
import org.opencastproject.mediapackage.MediaPackage;
import org.opencastproject.mediapackage.MediaPackageException;
import org.opencastproject.util.NotFoundException;

import java.util.Set;

/**
 * Publishes elements from MediaPackages to OAI-PMH.
 */
public interface OaiPmhPublicationService {

  /**
   * Identifier for service registration and location
   */
  String JOB_TYPE = "org.opencastproject.publication.oaipmh";

  /**
   * The Opencast publication channel id is created from the OAI-PMH channel name prefixed by the
   * {@link #PUBLICATION_CHANNEL_PREFIX}.
   */
  String PUBLICATION_CHANNEL_PREFIX = "oaipmh-";

  /**
   * Publishes some media package elements.
   * 
   * @param mediaPackage
   *          the media package
   * @param repository
   *          the OAI-PMH repository
   * @param downloadElementIds
   *          the download element ids to publish
   * @param streamingElementIds
   *          the streaming element ids to publish
   * @param checkAvailability
   *          whether to check the distributed download artifacts are available at its URL
   * @return The job
   * @throws PublicationException
   *           if there was a problem publishing the media
   * @throws MediaPackageException
   *           if there was a problem with the mediapackage element
   */
  Job publish(MediaPackage mediaPackage, String repository, Set<String> downloadElementIds,
      Set<String> streamingElementIds, boolean checkAvailability) throws PublicationException,
      MediaPackageException;

  /**
   * Retract a media package from the publication channel.
   * 
   * @param mediaPackage
   *          the media package
   * @param repository
   *          the OAI-PMH repository
   * @throws NotFoundException
   *           if there was no mediapackage to retract from this channel
   * @throws PublicationException
   *           if there was a problem retracting the mediapackage
   */
  Job retract(MediaPackage mediaPackage, String repository) throws PublicationException, NotFoundException;

}
