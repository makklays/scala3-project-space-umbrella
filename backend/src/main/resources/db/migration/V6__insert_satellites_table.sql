-- V6__insert_initial_space_assets.sql
-- Migration #6: Insert initial categories and tactical space assets data

-- 1. Наполняем таблицу категорий (Categories)
-- Populating specialized Space Force & Intel categories
INSERT INTO categories (id, title, description) VALUES
(
    1,
    'SIGINT & Cyber-Espionage',
    'Signals Intelligence assets designed for advanced eavesdropping, interception of communications, and global radio-frequency tracking.'
),
(
    2,
    'Tactical SATCOM & Mobile Grid',
    'Secure military satellite communication relays providing encrypted, high-availability mobile networks for field operations.'
),
(
    3,
    'Orbital Broadband Internet',
    'Next-gen mega-constellations supplying high-throughput, low-latency space internet for real-time tactical data distribution.'
),
(
    4,
    'Optical & Radar Reconnaissance',
    'Imagery Intelligence (IMINT) platforms equipped with synthetic aperture radar (SAR) and high-resolution cameras for planet monitoring.'
),
(
    5,
    'Deep-Space Anomaly (UAP)',
    'Classified tracking register for Unidentified Anomalous Phenomena displaying non-human technology signatures.'
)
ON CONFLICT (id) DO NOTHING;

-- Корректируем счетчик ID для BIGSERIAL после ручной вставки
SELECT setval('categories_id_seq', (SELECT MAX(id) FROM categories));

-- 2. Наполнение таблицы: Ровно 10 тактических объектов
INSERT INTO satellites (
    category_id, norad_cat_id, cospar_id, title, description,
    apogee_km, perigee_km, inclination_deg, orbital_period,
    operational_status, threat_level, launch_date
) VALUES
-- --- КАТЕГОРИЯ 1: SIGINT & Cyber-Espionage (Прослушивание) ---
(
    1, 41724, '2016-036A', 'USA-268 (Orion 9 / Mentor)',
    'Heavy signals intelligence satellite operating in geostationary orbit. Equipped with a massive mesh antenna to intercept global radio-frequencies and telemetry.',
    35792.0, 35775.0, 0.02, 1436.1, 'ACTIVE', 0, '2016-06-11 17:51:00+00'
),
(
    1, 40144, '2014-055A', 'USA-257 (Intruder 11)',
    'Naval Ocean Surveillance System (NOSS) asset used to intercept encrypted military transmissions from marine vessels and track adversary fleet positions.',
    1200.0, 1050.0, 63.4, 107.8, 'ACTIVE', 0, '2014-09-17 00:16:00+00'
),
-- --- КАТЕГОРИЯ 2: Tactical SATCOM & Mobile Grid (Мобильная связь) ---
(
    2, 45453, '2020-025A', 'USSF-7 (AEHF-6)',
    'Advanced Extreme High Frequency satellite providing highly secure, jam-resistant, and nuclear-survivable mobile communications for US strategic command.',
    35796.0, 35774.0, 0.01, 1436.2, 'ACTIVE', 0, '2020-03-26 20:18:00+00'
),
(
    2, 41785, '2016-041A', 'MUOS-5 (Mobile User Objective System)',
    'Tactical UHF satellite operating as a smartphone tower in space. Delivers high-availability mobile grid connection for troops on the move.',
    35785.0, 35750.0, 4.8, 1436.0, 'ACTIVE', 1, '2016-06-24 14:30:00+00'
),
-- --- КАТЕГОРИЯ 3: Orbital Broadband Internet (Интернет) ---
(
    3, 58120, '2023-150A', 'Starshield-Tactical-01',
    'Militarized low-Earth orbit broadband satellite managed under Pentagon secure network contracts. Provides high-throughput data to field command terminals.',
    560.0, 550.0, 53.0, 95.8, 'ACTIVE', 0, '2023-10-05 04:12:00+00'
),
(
    3, 62045, '2025-012C', 'SDA-Tranche1-Transport-04',
    'Space Development Agency high-speed transport layer satellite designed to route huge real-time combat data directly to tactical weapon systems.',
    950.0, 940.0, 81.0, 104.1, 'ACTIVE', 0, '2025-01-18 11:05:00+00'
),
-- --- КАТЕГОРИЯ 4: Optical & Radar Reconnaissance (Разведка) ---
(
    4, 43845, '2019-001A', 'USA-290 (Keyhole KH-11)',
    'Electro-optical spy satellite with a Hubble-sized mirror. Captures ultra-high-resolution intelligence imagery of strategic installations in real time.',
    1010.0, 260.0, 97.9, 97.4, 'ACTIVE', 0, '2019-01-19 19:10:00+00'
),
(
    4, 49610, '2021-085A', 'USA-314 (Topaz 5 / Radar)',
    'Synthetic Aperture Radar (SAR) intelligence platform capable of penetrating thick cloud covers, dust storms, and night darkness for continuous battlefield mapping.',
    1105.0, 1102.0, 123.0, 107.2, 'ACTIVE', 0, '2021-09-20 22:45:00+00'
),
(
    4, 39120, '2013-012B', 'Legacy Lacrosse-5 (Decommissioned)',
    'Older generation radar reconnaissance asset. Decommissioned after completing its optical mapping mission cycle. Currently tracking as space debris.',
    670.0, 665.0, 57.0, 98.1, 'DECAYED', 0, '2013-04-03 18:24:00+00'
),
-- --- КАТЕГОРИЯ 5: Deep-Space Anomaly (UAP) (НЛО / Пришельцы) ---
(
    5, 99999, '2026-UNK-01', 'Tactical Anomaly "Tic-Tac"',
    'Deep-space atmospheric object tracked over Navy carrier strike group operations area. Demonstrates non-ballistic acceleration and zero thermal propulsion traces.',
    120400.0, 80.0, 94.5, 450.0, 'UNKNOWN_ANOMALY', 5, '2026-02-14 04:20:00+00'
)
ON CONFLICT (norad_cat_id) DO NOTHING;

