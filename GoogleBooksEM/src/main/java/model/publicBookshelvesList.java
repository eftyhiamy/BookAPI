package model;


public class publicBookshelvesList {
	private final String kind;
	private final String id;
	private final String title;
	private final String access;
	private final String updated;
	private final String created;
	private final String volumeCount;
	private final String volumeLastUpdated;
	
	public publicBookshelvesList (String kind, String id, String title, String access, String updated, String created, String volumeCount, String volumeLastUpdated) {
		this.kind = kind;
		this.id = id;
		this.title = title;
		this.access = access;
		this.updated = updated;
		this.created = created;
		this.volumeCount = volumeCount;
		this.volumeLastUpdated = volumeLastUpdated;
	}
		public String getKind() {
			return kind;
		}

		public String getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getAccess() {
			return access;
		}

		public String getUpdated() {
			return updated;
		}

		public String getCreated() {
			return created;
		}

		public String getVolumeCount() {
			return volumeCount;
		}

		public String getVolumeLastUpdated() {
			return volumeLastUpdated;
		}
		@Override
		public String toString() {
			return "publicBookshelvesList [kind=" + kind + ", id=" + id + ", title=" + title + ", access=" + access
					+ ", updated=" + updated + ", created=" + created + ", volumeCount=" + volumeCount
					+ ", volumeLastUpdated=" + volumeLastUpdated + "]";
		}
	
	}
