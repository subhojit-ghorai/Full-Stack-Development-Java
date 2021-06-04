/**
 * This class is generated by jOOQ
 */
package tech.codingclub.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Songdb extends org.jooq.impl.TableImpl<tech.codingclub.tables.records.SongdbRecord> {

	private static final long serialVersionUID = -139713770;

	/**
	 * The singleton instance of <code>public.Songdb</code>
	 */
	public static final tech.codingclub.tables.Songdb SONGDB = new tech.codingclub.tables.Songdb();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<tech.codingclub.tables.records.SongdbRecord> getRecordType() {
		return tech.codingclub.tables.records.SongdbRecord.class;
	}

	/**
	 * The column <code>public.Songdb.album_name</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> ALBUM_NAME = createField("album_name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.Songdb.album_image_link</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> ALBUM_IMAGE_LINK = createField("album_image_link", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.Songdb.cast</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> CAST = createField("cast", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.Songdb.music_composer</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> MUSIC_COMPOSER = createField("music_composer", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.Songdb.song_name</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> SONG_NAME = createField("song_name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.Songdb.song_download_link</code>.
	 */
	public final org.jooq.TableField<tech.codingclub.tables.records.SongdbRecord, java.lang.String> SONG_DOWNLOAD_LINK = createField("song_download_link", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * Create a <code>public.Songdb</code> table reference
	 */
	public Songdb() {
		this("Songdb", null);
	}

	/**
	 * Create an aliased <code>public.Songdb</code> table reference
	 */
	public Songdb(java.lang.String alias) {
		this(alias, tech.codingclub.tables.Songdb.SONGDB);
	}

	private Songdb(java.lang.String alias, org.jooq.Table<tech.codingclub.tables.records.SongdbRecord> aliased) {
		this(alias, aliased, null);
	}

	private Songdb(java.lang.String alias, org.jooq.Table<tech.codingclub.tables.records.SongdbRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, tech.codingclub.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public tech.codingclub.tables.Songdb as(java.lang.String alias) {
		return new tech.codingclub.tables.Songdb(alias, this);
	}

	/**
	 * Rename this table
	 */
	public tech.codingclub.tables.Songdb rename(java.lang.String name) {
		return new tech.codingclub.tables.Songdb(name, null);
	}
}
