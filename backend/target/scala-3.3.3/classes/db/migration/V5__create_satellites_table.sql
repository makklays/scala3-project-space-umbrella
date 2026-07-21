-- V5__create_satellites_table.sql
-- Migration #5: create table satellites

-- Creating table 'satellites' based on US Space Force (USSF) Space-Track data standards
CREATE TABLE IF NOT EXISTS satellites
(
    id                BIGSERIAL PRIMARY KEY,
    category_id       BIGINT NOT NULL REFERENCES categories(id) ON DELETE RESTRICT,

    -- USSF Identification Elements
    norad_cat_id      INTEGER NOT NULL UNIQUE,       -- Official USSF/NORAD Catalog Number (Alpha-5 compliant)
    cospar_id         VARCHAR(50) NOT NULL UNIQUE,   -- International Designator (e.g., "2024-001A")
    title             VARCHAR(255) NOT NULL,         -- Official name of the asset (e.g., "GPS III-06")
    description       TEXT,                          -- Mission objective details

    -- Telemetry & Orbital Mechanics
    apogee_km         DOUBLE PRECISION NOT NULL,     -- Highest point of orbit in kilometers
    perigee_km        DOUBLE PRECISION NOT NULL,     -- Lowest point of orbit in kilometers
    inclination_deg   DOUBLE PRECISION NOT NULL,     -- Orbital inclination in degrees (0 to 180)
    orbital_period    DOUBLE PRECISION NOT NULL,     -- Time taken to complete one orbit (in minutes)

    -- Operational Status & Anomaly Tracking
    operational_status VARCHAR(50) NOT NULL,        -- 'ACTIVE', 'DECAYED' (Sunk), 'UNKNOWN_ANOMALY' (Alien target)
    threat_level      INT DEFAULT 0,                 -- Tactical threat scale (0 = Safe, 5 = Extreme Danger)

    -- Metadata
    launch_date       TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at        TIMESTAMP WITH TIME ZONE DEFAULT now(),
    updated_at        TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- Indexes for lightning-fast tactical search and lookups
CREATE INDEX idx_satellites_norad_cat_id ON satellites(norad_cat_id);
CREATE INDEX idx_satellites_title ON satellites(title);
CREATE INDEX idx_satellites_category_id ON satellites(category_id);
CREATE INDEX idx_satellites_status ON satellites(operational_status);

